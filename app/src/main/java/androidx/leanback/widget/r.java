package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.j;
import androidx.leanback.widget.q;

/* compiled from: ItemAlignmentFacetHelper.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Rect f3337a = new Rect();

    public static int a(View view, q.a aVar, int i10) {
        View viewFindViewById;
        int i11;
        int height;
        int width;
        int width2;
        int width3;
        j.d dVar = (j.d) view.getLayoutParams();
        int i12 = aVar.f3324a;
        if (i12 == 0 || (viewFindViewById = view.findViewById(i12)) == null) {
            viewFindViewById = view;
        }
        int paddingBottom = aVar.f3326c;
        Rect rect = f3337a;
        if (i10 != 0) {
            if (aVar.f3328e) {
                float f10 = aVar.f3327d;
                if (f10 == 0.0f) {
                    paddingBottom += viewFindViewById.getPaddingTop();
                } else if (f10 == 100.0f) {
                    paddingBottom -= viewFindViewById.getPaddingBottom();
                }
            }
            if (aVar.f3327d != -1.0f) {
                if (viewFindViewById == view) {
                    dVar.getClass();
                    height = (viewFindViewById.getHeight() - dVar.f3265f) - dVar.f3267h;
                } else {
                    height = viewFindViewById.getHeight();
                }
                paddingBottom += (int) ((height * aVar.f3327d) / 100.0f);
            }
            if (view != viewFindViewById) {
                rect.top = paddingBottom;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
                i11 = rect.top - dVar.f3265f;
            } else {
                i11 = paddingBottom;
            }
            return aVar.isAlignedToTextViewBaseLine() ? i11 + viewFindViewById.getBaseline() : i11;
        }
        if (view.getLayoutDirection() != 1) {
            if (aVar.f3328e) {
                float f11 = aVar.f3327d;
                if (f11 == 0.0f) {
                    paddingBottom += viewFindViewById.getPaddingLeft();
                } else if (f11 == 100.0f) {
                    paddingBottom -= viewFindViewById.getPaddingRight();
                }
            }
            if (aVar.f3327d != -1.0f) {
                if (viewFindViewById == view) {
                    dVar.getClass();
                    width = (viewFindViewById.getWidth() - dVar.f3264e) - dVar.f3266g;
                } else {
                    width = viewFindViewById.getWidth();
                }
                paddingBottom += (int) ((width * aVar.f3327d) / 100.0f);
            }
            int i13 = paddingBottom;
            if (view == viewFindViewById) {
                return i13;
            }
            rect.left = i13;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
            return rect.left - dVar.f3264e;
        }
        if (viewFindViewById == view) {
            dVar.getClass();
            width2 = (viewFindViewById.getWidth() - dVar.f3264e) - dVar.f3266g;
        } else {
            width2 = viewFindViewById.getWidth();
        }
        int paddingLeft = width2 - paddingBottom;
        if (aVar.f3328e) {
            float f12 = aVar.f3327d;
            if (f12 == 0.0f) {
                paddingLeft -= viewFindViewById.getPaddingRight();
            } else if (f12 == 100.0f) {
                paddingLeft += viewFindViewById.getPaddingLeft();
            }
        }
        if (aVar.f3327d != -1.0f) {
            if (viewFindViewById == view) {
                dVar.getClass();
                width3 = (viewFindViewById.getWidth() - dVar.f3264e) - dVar.f3266g;
            } else {
                width3 = viewFindViewById.getWidth();
            }
            paddingLeft -= (int) ((width3 * aVar.f3327d) / 100.0f);
        }
        if (view == viewFindViewById) {
            return paddingLeft;
        }
        rect.right = paddingLeft;
        ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
        return rect.right + dVar.f3266g;
    }
}
