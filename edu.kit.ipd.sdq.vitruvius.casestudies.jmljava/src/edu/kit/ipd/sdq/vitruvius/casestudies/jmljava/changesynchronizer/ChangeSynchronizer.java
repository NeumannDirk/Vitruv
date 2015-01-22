package edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.changesynchronizer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.extensions.SynchronisationListener;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.synchronizers.SynchronisationAbortedListener;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.vitruvius.changesynchronizer.ModelProvidingDirtyMarker;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.vitruvius.changesynchronizer.internal.VitruviusChangeSynchronizer;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Change;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.EMFModelChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.ChangeSynchronizing;

/**
 * Singleton implementation of the ChangeSynchronizer. Listeners can register to be informed about
 * the synchronization status (e.g. to stop listening for changes).
 */
public final class ChangeSynchronizer implements ChangeSynchronizing, SynchronisationAbortedListener {

    private static final Logger LOGGER = Logger.getLogger(ChangeSynchronizing.class);

    private final VitruviusChangeSynchronizer vitruviusSynchronizer = new VitruviusChangeSynchronizer();
    private final Set<SynchronisationListener> listeners = new HashSet<SynchronisationListener>();
    private boolean doNotAcceptNewChanges = false;
    
    /**
     * Registers a listener for the synchronization status.
     * 
     * @param listener
     *            The listener to register.
     */
    public synchronized void register(SynchronisationListener listener) {
        listeners.add(listener);
    }

    /**
     * Unregisters a listener for the synchronization status.
     * 
     * @param listener
     *            The listener to unregister.
     */
    public synchronized void unregister(SynchronisationListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void synchronizeChanges(List<Change> changes) {
    	if (doNotAcceptNewChanges) {
    		return;
    	}
        synchronized (vitruviusSynchronizer) {
            notifyListenersSynchronisationStarted();
            vitruviusSynchronizer.synchronizeChanges(changes);
            notifyListenersSynchronisationFinished();
        }
    }

    @Override
    public void synchronizeChange(Change change) {
    	if (doNotAcceptNewChanges) {
    		return;
    	}
        synchronized (vitruviusSynchronizer) {
            notifyListenersSynchronisationStarted();
            vitruviusSynchronizer.synchronizeChange(change);
            notifyListenersSynchronisationFinished();
        }
    }

    @Override
    public void synchronisationAborted(EMFModelChange abortedChange) {
        notifyListenersSynchronisationAborted(abortedChange);
    }
    

    @Override
    public void synchronisationAborted(TransformationAbortCause cause) {
        notifyListenersSynchronisationAborted(cause);
    }

    /**
     * Informs all listeners about the start of a synchronization.
     */
    private void notifyListenersSynchronisationStarted() {
        notifyListeners(new ListenerCaller<SynchronisationListener>() {
            @Override
            public void notifyListener(SynchronisationListener listener) {
                listener.syncStarted();
            }
        });
    }

    /**
     * Informs all listeners about the end of a synchronization.
     */
    private void notifyListenersSynchronisationFinished() {
        notifyListeners(new ListenerCaller<SynchronisationListener>() {
            @Override
            public void notifyListener(SynchronisationListener listener) {
                listener.syncFinished();
            }
        });
    }

    /**
     * Informs all listeners that the synchronisation has been aborted.
     * 
     * @param abortedChange
     *            The unprocessed change because of the aborted transformation.
     */
    private void notifyListenersSynchronisationAborted(final EMFModelChange abortedChange) {
        notifyListeners(new ListenerCaller<SynchronisationListener>() {
            @Override
            public void notifyListener(SynchronisationListener listener) {
                listener.syncAborted(abortedChange);
            }
        });
    }
    
    /**
     * Informs all listeners that the synchronisation has been aborted.
     * 
     * @param cause
     *            The cause for the abortion.
     */
    private void notifyListenersSynchronisationAborted(final TransformationAbortCause cause) {
        notifyListeners(new ListenerCaller<SynchronisationListener>() {
            @Override
            public void notifyListener(SynchronisationListener listener) {
                listener.syncAborted(cause);
            }
        });
    }

    /**
     * Informs the given listener by calling one or more methods of it.
     * 
     * @author Stephan Seifermann
     *
     * @param <T>
     *            The type of the listener
     */
    private interface ListenerCaller<T> {

        /**
         * Informs the given listener.
         * 
         * @param listener
         *            The listener to be informed.
         */
        void notifyListener(T listener);
    }

    /**
     * Notifies all listeners by passing the listener to the notify method of the given parameter.
     * 
     * @param notifiable
     *            The notifier, which informs the listener.
     */
    private void notifyListeners(ListenerCaller<SynchronisationListener> notifiable) {
        for (SynchronisationListener listener : listeners) {
            try {
                notifiable.notifyListener(listener);
            } catch (Exception e) {
                LOGGER.warn("Exception thrown by " + listener + " after notifying it.", e);
            }
        }
    }
    
    public ModelProvidingDirtyMarker getModelProvidingDirtyMarker() {
    	return vitruviusSynchronizer.getModelProvidingDirtyMarker();
    }
    
    public void doNotAcceptNewChanges() {
    	doNotAcceptNewChanges = true;
    }

}
