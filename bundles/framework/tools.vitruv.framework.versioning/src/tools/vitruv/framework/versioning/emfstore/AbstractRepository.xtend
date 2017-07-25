package tools.vitruv.framework.versioning.emfstore

import tools.vitruv.framework.versioning.branch.Branch
import tools.vitruv.framework.versioning.commit.Commit
import java.util.List
import tools.vitruv.framework.versioning.commit.SimpleCommit

interface AbstractRepository {
	def Branch getMasterBranch()

	def Commit getHead()

	def List<Commit> getCommits()

	def List<Commit> getCommits(Branch branch)

	def List<Commit> getCommitsFrom(String from)

	def SimpleCommit getInitialCommit()

	def String getId()

	def String getName()

	def void setName(String name)

}
