package Kerning;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;


public class KogiButton extends KogiTextView {

    public KogiButton(Context context) {
        super(context);
    }

    public KogiButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KogiButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }
}
