package controller;

import common.observer.Observer;
import model.Model;
import view.UiEvent;
import view.View;

public class ControllerImpl implements Controller {

    private final Model model;

    // TODO: observer of ui events

    public ControllerImpl(View view, Model model) {
        this.model = model;
        // TODO suscribe observer to ui
    }

    // TODO: handle observed ui events

}
