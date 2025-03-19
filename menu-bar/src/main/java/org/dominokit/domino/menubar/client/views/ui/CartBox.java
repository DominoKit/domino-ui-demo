package org.dominokit.domino.menubar.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;

public class CartBox extends BaseDominoElement<HTMLDivElement, CartBox> {

    private static final CssClass dui_cart_box = ()-> "dui-cart-box";
    private static final BooleanCssClass dui_cart_box_overflow = BooleanCssClass.of(()-> "dui-cart-box-overflow");

    private final DivElement cart;
    private final double limit = 100.0;

    public CartBox() {
        this.cart = div()
                .addCss(dui_cart_box);
        init(this);
    }

    public void addItem(String id, double price){
        //add item logic
        dui_cart_box_overflow.apply(this, calculateTotalPrice() > limit);
    }

    public void removeItem(String id){
        //remove item logic
        dui_cart_box_overflow.apply(this, calculateTotalPrice() > limit);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        //add calculate price logic here;
        return totalPrice;
    }

    @Override
    public HTMLDivElement element() {
        return this.cart.element();
    }
}
