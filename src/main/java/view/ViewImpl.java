package view;

import common.observer.Observable;
import common.observer.Subject;
import model.ModelInjector;
import model.entities.SimpsonsQuote;

public class ViewImpl implements View {

    private final UiComponents uiComponents;
    private final Subject<UiEvent> onActionSubject = new Subject<>();
    private UiState uiState = new UiState();

    public ViewImpl(UiComponents uiComponents) {
        this.uiComponents = uiComponents;
        initListeners();
        initObservers();
    }

    private void initListeners() {
        uiComponents.getFetchQuoteButton().addActionListener(e -> notifyFetchQuoteAction());
    }

    private void notifyFetchQuoteAction() {
        onActionSubject.notify(UiEvent.FETCH_QUOTE);
    }

    private void initObservers() {
        ModelInjector.getInstance().getModel()
                .getSimpsonsQuoteObservable().suscribe(this::updateQuote);
    }

    private void updateQuote(SimpsonsQuote quote) {
        updateUiState(quote);
        updateUiComponents();
    }

    private void updateUiState(SimpsonsQuote quote) {
        uiState = new UiState(quote.getQuote(), quote.getCharacter());
    }

    private void updateUiComponents() {
        uiComponents.getQuoteTextArea().setText(uiState.getQuote());
        uiComponents.getCharacterTextField().setText(uiState.getCharacter());
    }

    @Override
    public void openView() {
        uiComponents.openWindow();
    }

    @Override
    public Observable<UiEvent> getUiEventObservable() {
        return onActionSubject;
    }

    @Override
    public UiState getUiState() {
        return uiState;
    }
}
