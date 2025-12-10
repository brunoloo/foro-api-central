package com.brunoloo.foro_app_java.exceptions;

    @SuppressWarnings("serial")
    public class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
}
