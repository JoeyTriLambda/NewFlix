package i4;

import com.github.ybq.android.spinkit.Style;
import l4.f;
import m4.b;
import m4.c;
import m4.d;
import m4.e;
import m4.g;
import m4.h;
import m4.i;
import m4.j;
import m4.k;
import m4.l;
import m4.m;
import m4.n;
import m4.o;

/* compiled from: SpriteFactory.java */
/* loaded from: classes.dex */
public final class a {
    public static f create(Style style) {
        switch (style) {
            case ROTATING_PLANE:
                return new l();
            case DOUBLE_BOUNCE:
                return new d();
            case WAVE:
                return new o();
            case WANDERING_CUBES:
                return new n();
            case PULSE:
                return new i();
            case CHASING_DOTS:
                return new m4.a();
            case THREE_BOUNCE:
                return new m();
            case CIRCLE:
                return new b();
            case CUBE_GRID:
                return new c();
            case FADING_CIRCLE:
                return new e();
            case FOLDING_CUBE:
                return new m4.f();
            case ROTATING_CIRCLE:
                return new k();
            case MULTIPLE_PULSE:
                return new g();
            case PULSE_RING:
                return new j();
            case MULTIPLE_PULSE_RING:
                return new h();
            default:
                return null;
        }
    }
}
