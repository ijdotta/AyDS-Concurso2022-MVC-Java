package model;

import common.observer.Subject;
import lombok.Getter;
import model.entities.SimpsonsQuote;
import model.external.SimpsonsService;

public class ModelImpl implements Model {
    @Getter
    private final Subject<SimpsonsQuote> simpsonsQuoteObservable = new Subject<>();

    private final SimpsonsService simpsonsService;

    public ModelImpl(SimpsonsService simpsonsService) {
        this.simpsonsService = simpsonsService;
    }

    @Override
    public void fetchQuote() {
        // TODO: get quote and notify
    }
}
