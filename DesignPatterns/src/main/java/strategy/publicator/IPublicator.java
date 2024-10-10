package strategy.publicator;


import strategy.model.PublicatorType;

public interface IPublicator
{
    void publish();
    PublicatorType getType();
}
