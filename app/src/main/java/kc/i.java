package kc;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import flix.com.vision.R;
import flix.com.vision.bvp.BetterVideoPlayer;
import java.text.DecimalFormat;
import java.util.Objects;

/* compiled from: SubtitleOffsetDialog.java */
/* loaded from: classes2.dex */
public final class i extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    public Button f15080b;

    /* renamed from: m, reason: collision with root package name */
    public Button f15081m;

    /* renamed from: n, reason: collision with root package name */
    public Button f15082n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f15083o;

    /* renamed from: p, reason: collision with root package name */
    public EditText f15084p;

    /* renamed from: q, reason: collision with root package name */
    public BetterVideoPlayer f15085q;

    public static i newInstance(BetterVideoPlayer betterVideoPlayer) {
        i iVar = new i();
        iVar.f15085q = betterVideoPlayer;
        return iVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window = getDialog().getWindow();
        Objects.requireNonNull(window);
        final int i10 = 1;
        window.requestFeature(1);
        setCancelable(true);
        final int i11 = 0;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_subtitle_offset_dialog, viewGroup, false);
        this.f15082n = (Button) viewInflate.findViewById(R.id.button_set_finish);
        this.f15081m = (Button) viewInflate.findViewById(R.id.button_minus_offset);
        this.f15080b = (Button) viewInflate.findViewById(R.id.button_plus_offset);
        this.f15084p = (EditText) viewInflate.findViewById(R.id.edit_text_offset);
        this.f15083o = (TextView) viewInflate.findViewById(R.id.value_text_view);
        this.f15081m.setOnClickListener(new View.OnClickListener(this) { // from class: kc.f

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ i f15076m;

            {
                this.f15076m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                String str;
                int i12 = i11;
                double d10 = 0.0d;
                i iVar = this.f15076m;
                switch (i12) {
                    case 0:
                        String strTrim = iVar.f15084p.getText().toString().trim();
                        str = strTrim.isEmpty() ? "0.0" : strTrim;
                        if (str.length() > 0) {
                            try {
                                d10 = Double.parseDouble(str);
                            } catch (NumberFormatException e10) {
                                e10.printStackTrace();
                            }
                        }
                        String str2 = new DecimalFormat("###.###").format(d10 - 0.1d);
                        iVar.f15084p.setText(str2);
                        iVar.f15083o.setText(str2 + " s");
                        iVar.f15083o.setTag(str2 + "");
                        break;
                    case 1:
                        String strTrim2 = iVar.f15084p.getText().toString().trim();
                        str = strTrim2.isEmpty() ? "0.0" : strTrim2;
                        if (str.length() > 0) {
                            try {
                                d10 = Double.parseDouble(str);
                            } catch (NumberFormatException e11) {
                                e11.printStackTrace();
                            }
                        }
                        String str3 = new DecimalFormat("###.###").format(d10 + 0.1d);
                        iVar.f15084p.setText(str3);
                        iVar.f15083o.setText(str3 + " s");
                        iVar.f15083o.setTag(str3 + "");
                        break;
                    default:
                        iVar.dismiss();
                        break;
                }
            }
        });
        this.f15080b.setOnClickListener(new View.OnClickListener(this) { // from class: kc.f

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ i f15076m;

            {
                this.f15076m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                String str;
                int i12 = i10;
                double d10 = 0.0d;
                i iVar = this.f15076m;
                switch (i12) {
                    case 0:
                        String strTrim = iVar.f15084p.getText().toString().trim();
                        str = strTrim.isEmpty() ? "0.0" : strTrim;
                        if (str.length() > 0) {
                            try {
                                d10 = Double.parseDouble(str);
                            } catch (NumberFormatException e10) {
                                e10.printStackTrace();
                            }
                        }
                        String str2 = new DecimalFormat("###.###").format(d10 - 0.1d);
                        iVar.f15084p.setText(str2);
                        iVar.f15083o.setText(str2 + " s");
                        iVar.f15083o.setTag(str2 + "");
                        break;
                    case 1:
                        String strTrim2 = iVar.f15084p.getText().toString().trim();
                        str = strTrim2.isEmpty() ? "0.0" : strTrim2;
                        if (str.length() > 0) {
                            try {
                                d10 = Double.parseDouble(str);
                            } catch (NumberFormatException e11) {
                                e11.printStackTrace();
                            }
                        }
                        String str3 = new DecimalFormat("###.###").format(d10 + 0.1d);
                        iVar.f15084p.setText(str3);
                        iVar.f15083o.setText(str3 + " s");
                        iVar.f15083o.setTag(str3 + "");
                        break;
                    default:
                        iVar.dismiss();
                        break;
                }
            }
        });
        this.f15084p.addTextChangedListener(new h(this));
        final int i12 = 2;
        this.f15082n.setOnClickListener(new View.OnClickListener(this) { // from class: kc.f

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ i f15076m;

            {
                this.f15076m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                String str;
                int i122 = i12;
                double d10 = 0.0d;
                i iVar = this.f15076m;
                switch (i122) {
                    case 0:
                        String strTrim = iVar.f15084p.getText().toString().trim();
                        str = strTrim.isEmpty() ? "0.0" : strTrim;
                        if (str.length() > 0) {
                            try {
                                d10 = Double.parseDouble(str);
                            } catch (NumberFormatException e10) {
                                e10.printStackTrace();
                            }
                        }
                        String str2 = new DecimalFormat("###.###").format(d10 - 0.1d);
                        iVar.f15084p.setText(str2);
                        iVar.f15083o.setText(str2 + " s");
                        iVar.f15083o.setTag(str2 + "");
                        break;
                    case 1:
                        String strTrim2 = iVar.f15084p.getText().toString().trim();
                        str = strTrim2.isEmpty() ? "0.0" : strTrim2;
                        if (str.length() > 0) {
                            try {
                                d10 = Double.parseDouble(str);
                            } catch (NumberFormatException e11) {
                                e11.printStackTrace();
                            }
                        }
                        String str3 = new DecimalFormat("###.###").format(d10 + 0.1d);
                        iVar.f15084p.setText(str3);
                        iVar.f15083o.setText(str3 + " s");
                        iVar.f15083o.setTag(str3 + "");
                        break;
                    default:
                        iVar.dismiss();
                        break;
                }
            }
        });
        this.f15082n.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: kc.g

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ i f15078m;

            {
                this.f15078m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i13 = i11;
                i iVar = this.f15078m;
                switch (i13) {
                    case 0:
                        if (!z10) {
                            iVar.f15082n.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15082n.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            iVar.f15081m.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15081m.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                    default:
                        if (!z10) {
                            iVar.f15080b.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15080b.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                }
            }
        });
        this.f15081m.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: kc.g

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ i f15078m;

            {
                this.f15078m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i13 = i10;
                i iVar = this.f15078m;
                switch (i13) {
                    case 0:
                        if (!z10) {
                            iVar.f15082n.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15082n.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            iVar.f15081m.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15081m.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                    default:
                        if (!z10) {
                            iVar.f15080b.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15080b.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                }
            }
        });
        this.f15080b.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: kc.g

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ i f15078m;

            {
                this.f15078m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i13 = i12;
                i iVar = this.f15078m;
                switch (i13) {
                    case 0:
                        if (!z10) {
                            iVar.f15082n.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15082n.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            iVar.f15081m.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15081m.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                    default:
                        if (!z10) {
                            iVar.f15080b.setTextColor(iVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            iVar.f15080b.setTextColor(iVar.getResources().getColor(R.color.black));
                            break;
                        }
                }
            }
        });
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        long offset = this.f15085q.getOffset();
        if (offset != 0) {
            this.f15084p.setText(new DecimalFormat("###.###").format(offset / 1000.0d));
        }
        new Handler().postDelayed(new vb.d(this, 4), 300L);
    }
}
