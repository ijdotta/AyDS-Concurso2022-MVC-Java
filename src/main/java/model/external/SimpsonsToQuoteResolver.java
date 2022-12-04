package model.external;

import model.entities.SimpsonsQuote;

public interface SimpsonsToQuoteResolver {
    SimpsonsQuote getQuoteFromExternalData(String serviceData);
}
