package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* compiled from: AtProtobuf.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f9785a;

    /* renamed from: b, reason: collision with root package name */
    public final Protobuf.IntEncoding f9786b = Protobuf.IntEncoding.DEFAULT;

    /* compiled from: AtProtobuf.java */
    /* renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    public static final class C0100a implements Protobuf {

        /* renamed from: a, reason: collision with root package name */
        public final int f9787a;

        /* renamed from: b, reason: collision with root package name */
        public final Protobuf.IntEncoding f9788b;

        public C0100a(int i10, Protobuf.IntEncoding intEncoding) {
            this.f9787a = i10;
            this.f9788b = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            C0100a c0100a = (C0100a) ((Protobuf) obj);
            return this.f9787a == c0100a.tag() && this.f9788b.equals(c0100a.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f9787a) + (this.f9788b.hashCode() ^ 2041407134);
        }

        public Protobuf.IntEncoding intEncoding() {
            return this.f9788b;
        }

        public int tag() {
            return this.f9787a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f9787a + "intEncoding=" + this.f9788b + ')';
        }
    }

    public static a builder() {
        return new a();
    }

    public Protobuf build() {
        return new C0100a(this.f9785a, this.f9786b);
    }

    public a tag(int i10) {
        this.f9785a = i10;
        return this;
    }
}
