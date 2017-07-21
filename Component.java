import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class Component implements Observer, Subject, Visitable, MutableTreeNode {
	String id;
	Component parent;
	List<Component> child;
	long creationTime;

	public abstract boolean contains(String id);

	public abstract User getUserByID(String id);

	@Override
	public void insert(MutableTreeNode child, int index) {
		if (this.getAllowsChildren()) {
			this.child.add(index, (Component) child);
		}
	}

	public void insert(MutableTreeNode child) {
		if (this.getAllowsChildren()) {
			this.child.add((Component) child);
		}
	}

	@Override
	public void remove(int index) {
		if (!this.isLeaf()) {
			this.child.remove(index);
		}
	}

	@Override
	public void remove(MutableTreeNode node) {
		if (!this.isLeaf()) {
			this.child.remove((Component) node);
		}
	}

	@Override
	public void setUserObject(Object object) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void removeFromParent() {
		this.parent.child.remove(this);
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		this.parent = (Group) newParent;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return this.isLeaf() ? null : this.child.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return this.isLeaf() ? 0 : this.child.size();
	}

	@Override
	public TreeNode getParent() {
		return this.parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		return -1;
	}

	@Override
	public boolean getAllowsChildren() {
		return (!(this instanceof User));
	}

	@Override
	public boolean isLeaf() {
		return this.child == null;
	}

	@Override
	public Enumeration children() {
		return this.isLeaf() ? null : (Enumeration) this.child;
	}

	public List<Tweet> getNewsFeed() {
		List<Tweet> tweets = new ArrayList<>();
		if (!isLeaf()) {
			for (Component c : child) {
				tweets.addAll(c.getNewsFeed());
			}
		} else {
			tweets.addAll(getNewsFeed());
		}
		return tweets;
	}
	
}
