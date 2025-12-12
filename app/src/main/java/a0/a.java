package a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.cardview.widget.CardView;

/* compiled from: CardViewApi21Impl.java */
/* loaded from: classes.dex */
public final class a implements c {
    public static d a(b bVar) {
        return (d) ((CardView.a) bVar).getCardBackground();
    }

    @Override // a0.c
    public ColorStateList getBackgroundColor(b bVar) {
        return a(bVar).getColor();
    }

    @Override // a0.c
    public float getElevation(b bVar) {
        return ((CardView.a) bVar).getCardView().getElevation();
    }

    @Override // a0.c
    public float getMaxElevation(b bVar) {
        return a(bVar).f36e;
    }

    @Override // a0.c
    public float getRadius(b bVar) {
        return a(bVar).getRadius();
    }

    @Override // a0.c
    public void initialize(b bVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        CardView.a aVar = (CardView.a) bVar;
        aVar.setCardBackground(new d(f10, colorStateList));
        View cardView = aVar.getCardView();
        cardView.setClipToOutline(true);
        cardView.setElevation(f11);
        setMaxElevation(aVar, f12);
    }

    @Override // a0.c
    public void onCompatPaddingChanged(b bVar) {
        setMaxElevation(bVar, getMaxElevation(bVar));
    }

    @Override // a0.c
    public void onPreventCornerOverlapChanged(b bVar) {
        setMaxElevation(bVar, getMaxElevation(bVar));
    }

    @Override // a0.c
    public void setBackgroundColor(b bVar, ColorStateList colorStateList) {
        a(bVar).setColor(colorStateList);
    }

    @Override // a0.c
    public void setElevation(b bVar, float f10) {
        ((CardView.a) bVar).getCardView().setElevation(f10);
    }

    @Override // a0.c
    public void setMaxElevation(b bVar, float f10) {
        d dVarA = a(bVar);
        CardView.a aVar = (CardView.a) bVar;
        boolean useCompatPadding = aVar.getUseCompatPadding();
        boolean preventCornerOverlap = aVar.getPreventCornerOverlap();
        if (f10 != dVarA.f36e || dVarA.f37f != useCompatPadding || dVarA.f38g != preventCornerOverlap) {
            dVarA.f36e = f10;
            dVarA.f37f = useCompatPadding;
            dVarA.f38g = preventCornerOverlap;
            dVarA.c(null);
            dVarA.invalidateSelf();
        }
        updatePadding(aVar);
    }

    @Override // a0.c
    public void setRadius(b bVar, float f10) {
        d dVarA = a(bVar);
        if (f10 == dVarA.f32a) {
            return;
        }
        dVarA.f32a = f10;
        dVarA.c(null);
        dVarA.invalidateSelf();
    }

    public void updatePadding(b bVar) {
        float f10;
        CardView.a aVar = (CardView.a) bVar;
        if (!aVar.getUseCompatPadding()) {
            aVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float maxElevation = getMaxElevation(aVar);
        float radius = getRadius(aVar);
        if (aVar.getPreventCornerOverlap()) {
            f10 = (float) (((1.0d - e.f43a) * radius) + maxElevation);
        } else {
            int i10 = e.f44b;
            f10 = maxElevation;
        }
        int iCeil = (int) Math.ceil(f10);
        int iCeil2 = (int) Math.ceil(e.a(maxElevation, radius, aVar.getPreventCornerOverlap()));
        aVar.setShadowPadding(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // a0.c
    public void initStatic() {
    }
}
