package com.github.guokaia.mekatok.core.lambda;

/**
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/3
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     * @return result
     * @throws Throwable 异常
     */
    T get() throws Throwable;

}
