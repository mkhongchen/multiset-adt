import java.util.*;
public class Tree {
    private Object root;
    private List<Tree> subtrees;

    public Tree(Object root, List<Tree> subtrees) {
        this.root = root;

        this.subtrees = Objects.requireNonNullElseGet(subtrees, ArrayList::new);
    }

    public Boolean isEmpty() {
        return root == null;
    }

    public Integer len() {
        if(this.isEmpty()) {
            return 0;
        }
        else{
            Integer size = 1;
            for(Tree subtree: subtrees) {
                size += subtree.len();
            }
            return size;
        }
    }
    public Integer count(Object item){
        if(this.isEmpty()) {
            return 0;
        }
        else {
            Integer num = 0;
            if(root == item) {num ++;}
            for(Tree subtree: subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }
    public String toString() {
        return this.str_indented(0);
    }
    private String str_indented(Integer depth) {
        if(this.isEmpty()) {
            return "";
        }
        else {
            StringBuilder s = new StringBuilder("    ".repeat(depth) + root.toString() + "\n");
            for(Tree subtree: subtrees) {
                s.append(subtree.str_indented(depth + 1));
            }
            return s.toString();
        }
    }

}
