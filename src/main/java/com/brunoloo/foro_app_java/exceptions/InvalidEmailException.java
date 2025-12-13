package com.brunoloo.foro_app_java.exceptions;

@SuppressWarnings("serial")
    public class InvalidEmailException extends Exception {
        public InvalidEmailException(String message) {
            super(message);
        }
}