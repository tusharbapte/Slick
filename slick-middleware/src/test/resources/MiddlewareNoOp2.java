package test;

import com.github.slick.middleware.Middleware;
import com.github.slick.middleware.Request;
import com.github.slick.middleware.BundleSlick;

public class MiddlewareNoOp2 extends Middleware {

    @Override
    public void handle(Request request, BundleSlick date) {
        request.next();
    }
}