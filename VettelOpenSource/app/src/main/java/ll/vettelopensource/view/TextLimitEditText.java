package ll.vettelopensource.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ZhangPeng on 8-26-0026.
 */

@SuppressLint("AppCompatCustomView")
public class TextLimitEditText extends EditText {

    ILimit mILimit;
    private String bChar;
    private int mLimitCount = 10;

    public void setLimitCount(int mLimitCount) {
        this.mLimitCount = mLimitCount;
    }

    public void setILimit(ILimit mILimit) {
        this.mILimit = mILimit;
    }


    public TextLimitEditText(Context context) {
        super(context);
        setLimitCharacter();
    }

    public TextLimitEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLimitCharacter();
    }

    public TextLimitEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLimitCharacter();
    }


    private void setLimitCharacter(){
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {
                bChar = c.toString();
            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {

                if (c.length() > mLimitCount) {
                    if(mILimit != null){
                        mILimit.onTextLimitNotify(mLimitCount);
                    }
                    removeTextChangedListener(this);
                    bChar = bChar.trim();
                    setText(bChar);
                    setSelection(bChar.length());
                    addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public interface ILimit{
        void onTextLimitNotify(int count);
    }
}
