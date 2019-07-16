package org.dominokit.domino.demo;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.List;

public class TypeScanner extends TreePathScanner<List<ClassTree>, Trees> {
    private List<ClassTree> classTrees = new ArrayList<>();

    public ClassTree scan(TypeElement typeElement, Trees trees) {
        assert typeElement.getKind() == ElementKind.CLASS;

        List<ClassTree> classTrees = this.scan(trees.getPath(typeElement), trees);
        assert classTrees.size() == 1;

        return classTrees.get(0);
    }

    @Override
    public List<ClassTree> scan(TreePath treePath, Trees trees) {
        super.scan(treePath, trees);
        return this.classTrees;
    }

    @Override
    public List<ClassTree> visitClass(ClassTree classTree, Trees trees) {
        this.classTrees.add(classTree);
        return super.visitClass(classTree, trees);
    }
}