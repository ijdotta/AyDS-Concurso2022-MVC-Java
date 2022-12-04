package controller;

import common.observer.Observer;
import model.Model;
import view.UiEvent;
import view.View;

public class ControllerImpl implements Controller {

    private final Model model;

    private final Observer<UiEvent> observer = value -> {
        switch (value) {
            case FETCH_QUOTE -> randomQuote();
        }
    };

    public ControllerImpl(View view, Model model) {
        this.model = model;
        view.getUiEventObservable().suscribe(observer);
    }

    private void randomQuote() {
        model.fetchQuote();
    }

}
