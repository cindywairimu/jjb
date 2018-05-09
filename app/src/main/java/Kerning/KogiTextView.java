package Kerning;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.util.Log;

import com.example.kogi.mysa.BuildConfig;
import com.example.kogi.mysa.R;

import static com.example.kogi.mysa.Kerning.KogiTextView.Kogi.NO_KERNING;

public class KogiTextView extends AppCompatTextView {

    private final String TAG = getClass().getSimpleName();

    private float kerningFactor = Kogi.NO_KERNING;
    private CharSequence originalText;

    public KogiTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public KogiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public KogiTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        TypedArray originalTypedArray = getContext().obtainStyledAttributes(attrs,
                new int[]{android.R.attr.text});
        TypedArray currentTypedArray = getContext().obtainStyledAttributes(attrs,
                R.styleable.KogiTextView, 0, defStyle);

        try {
            kerningFactor = currentTypedArray.getFloat(R.styleable.KogiTextView_kv_spacing,
                    Kogi.NO_KERNING);
            originalText = originalTypedArray.getText(0);
        } finally {
            originalTypedArray.recycle();
            currentTypedArray.recycle();
        }

        if (BuildConfig.DEBUG) {
            Log.d(TAG, String.format("Kogi Factor: %s", kerningFactor));
            Log.d(TAG, String.format("Original Text: %s", originalText));
        }

        applyKogiKern();
    }


    public float getKogiKernFactor() {
        return kerningFactor;
    }


    public void setKogiKernFactor(float KOGIKERN) {
        this.kerningFactor = KOGIKERN;
        applyKogiKern();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        applyKogiKern();
    }

    @Override
    public CharSequence getText() {
        return originalText;
    }

    //TODO

    private void applyKogiKern() {
        if (originalText == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            builder.append(originalText.charAt(i));
            if (i + 1 < originalText.length()) {
                builder.append("\u00A0");
            }
        }

        SpannableString finalText = new SpannableString(builder.toString());
        if (builder.toString().length() > 1) {
            for (int i = 1; i < builder.toString().length(); i += 2) {
                finalText.setSpan(
                        new ScaleXSpan((kerningFactor) / 10),
                        i,
                        i + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        super.setText(finalText, BufferType.SPANNABLE);
    }


    public class Kogi {
        public final static float NO_KERNING = 0;
        public final static float SMALL = 1;
        public final static float MEDIUM = 4;
        public final static float LARGE = 6;
    }
}
