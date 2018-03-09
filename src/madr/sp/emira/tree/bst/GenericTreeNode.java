package madr.sp.emira.tree.bst;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
*
*
* @since Jan 25, 2018
* @author <a href="mailto:yogesh@revemarketing.com">Yogesh Kaushik</a>
* @version ${version}, Oct 25, 2018, kaushik
*/
public class GenericTreeNode<T> {

    private T data;
    private Set<GenericTreeNode<T>> children;
    private GenericTreeNode<T> parent;

    public GenericTreeNode() {
        children = new HashSet<GenericTreeNode<T>>();
    }

    public GenericTreeNode(T pData) {
        this();
        data = pData;
    }

    public GenericTreeNode<T> getParent() {
        return parent;
    }

    public Set<GenericTreeNode<T>> getChildren() {
        return children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public GenericTreeNode<T> addChildren(Set<GenericTreeNode<T>> children) {
        for(GenericTreeNode<T> child : children) {
        	if (children.add(child)) {
        		child.parent = this;        		
        	}
        }
        return this;
    }

    public boolean addChild(GenericTreeNode<T> child) {
        child.parent = this;
        return children.add(child);
    }
    
    public boolean removeChild(GenericTreeNode<T> child) {
    	return children.remove(child);
    }

    public GenericTreeNode<T> removeChildren(Collection<GenericTreeNode<T>> pChildren) {
    	for (GenericTreeNode<T> child : pChildren) {
            if (this.children.remove(child)) {
                child.parent = null;
            }
        }
    	return this;
    }
    
    public Set<GenericTreeNode<T>> getNodesAtLevel(int level) {
    	Set<GenericTreeNode<T>> nodes = new HashSet<GenericTreeNode<T>>();
    	if (level==0) {
    		nodes.add(this);
    		return nodes;
    	}
    	if (level < 0) {
    		throw new IllegalArgumentException("Level can not be less than 0");
    	}
    	return getSetOfNodes(this,nodes,level);
    }
    
    private Set<GenericTreeNode<T>> getSetOfNodes(GenericTreeNode<T> node, Set<GenericTreeNode<T>> set, int level) {
    	level--;
    	if (level == 0) {
    		return node.getChildren();
    	}
    	Set<GenericTreeNode<T>> nodes = node.getChildren();
    	for (GenericTreeNode<T> n : nodes) {
    		set.addAll(getSetOfNodes(n, set, level));    		
    	}
    	return set;
    }
    
    public long findDepthOfNode(GenericTreeNode<T> node, T data) {
    	long depth = 0;
    	if (node.data == data) {
    		return depth;
    	}
    	return 0L;
    }
    
    public void removeChildren() {
    	this.children = new HashSet<GenericTreeNode<T>>();
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }
}