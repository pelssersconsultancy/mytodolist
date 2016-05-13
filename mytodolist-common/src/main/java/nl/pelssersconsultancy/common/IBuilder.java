package nl.pelssersconsultancy.common;


public interface IBuilder<S,T> {

    S build();

    T self();

}
