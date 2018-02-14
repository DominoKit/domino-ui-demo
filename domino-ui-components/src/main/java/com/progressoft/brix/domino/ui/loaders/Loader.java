package com.progressoft.brix.domino.ui.loaders;

import elemental2.dom.HTMLElement;

public class Loader {

    private boolean started=false;
    private HTMLElement target;
    private IsLoader loaderElement;


    public Loader(HTMLElement target, LoaderEffect type){
        this.target=target;
        this.loaderElement =LoaderFactory.make(type);
    }

    public Loader startLoading(){
        stopLoading();
        target.appendChild(loaderElement.getElement());
        target.classList.add("waitMe_container");
        started=true;

        return this;
    }

    public Loader stopLoading(){
        if(started){
            target.removeChild(loaderElement.getElement());
            target.classList.remove("waitMe_container");
            started=false;
        }

        return this;
    }

    public Loader setLoadingText(String text){
        loaderElement.setLoadingText(text);
        return this;
    }
}
