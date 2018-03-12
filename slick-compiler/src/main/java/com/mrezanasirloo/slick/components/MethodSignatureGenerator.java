package com.mrezanasirloo.slick.components;

import com.mrezanasirloo.slick.AnnotatedPresenter;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2017-02-24
 */

public interface MethodSignatureGenerator {
    MethodSpec.Builder generate(String name, AnnotatedPresenter ap, TypeName returns);
}
