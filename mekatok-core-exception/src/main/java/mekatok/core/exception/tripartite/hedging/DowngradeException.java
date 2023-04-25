package mekatok.core.exception.tripartite.hedging;

import mekatok.core.exception.ExceptionMark;

/**
 * 第三方降级策略被触发
 * @author aCay
 * @since 2022/8/8
 */
@ExceptionMark(code = "C0402", message = "Third-party downgrade policy is triggered")
public class DowngradeException extends HedgingException {

    public DowngradeException() {
    }

    public DowngradeException(String message) {
        super(message);
    }

    public DowngradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DowngradeException(Throwable cause) {
        super(cause);
    }

    public DowngradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
