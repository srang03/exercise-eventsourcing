package org.example.commandmodule.handler;

public interface CommandHandler<TCommand, TResult> {
    TResult handle(TCommand command);
}