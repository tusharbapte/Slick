package com.mrezanasirloo.slick;

import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.type.TypeMirror;

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2017-02-01
 *
 *         Model class for presenter parameters
 */

public class Arg {
    private String name;
    private TypeMirror type;
    private List<? extends AnnotationMirror> annotations;

    Arg(String name, TypeMirror type, List<? extends AnnotationMirror> annotations) {
        this.name = name;
        this.type = type;
        this.annotations = annotations;
    }

    /**
     * @return argument's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return argument's type
     */
    public TypeMirror getType() {
        return type;
    }

    /**
     * @return a list of argument's annotations
     */
    public List<? extends AnnotationMirror> getAnnotations() {
        return annotations;
    }
}
