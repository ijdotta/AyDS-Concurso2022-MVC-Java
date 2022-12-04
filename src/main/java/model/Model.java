package model;

import common.observer.Observable;
import model.entities.SimpsonsQuote;

public interface Model {
    Observable<SimpsonsQuote> getSimpsonsQuoteObservable();
    void fetchQuote();
}