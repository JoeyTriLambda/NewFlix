package com.bumptech.glide.load.engine;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class GlideException extends Exception {
    private static final long serialVersionUID = 1;

    public static void a(Throwable th2, ArrayList arrayList) {
        if (!(th2 instanceof GlideException)) {
            arrayList.add(th2);
            return;
        }
        Iterator<Throwable> it = ((GlideException) th2).getCauses().iterator();
        while (it.hasNext()) {
            a(it.next(), arrayList);
        }
    }

    public static void b(List list, a aVar) {
        try {
            c(list, aVar);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void c(List list, a aVar) throws IOException {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            aVar.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = (Throwable) list.get(i10);
            if (th2 instanceof GlideException) {
                GlideException glideException = (GlideException) th2;
                glideException.getClass();
                d(glideException, aVar);
                b(glideException.getCauses(), new a(aVar));
            } else {
                d(th2, aVar);
            }
            i10 = i11;
        }
    }

    public static void d(Throwable th2, Appendable appendable) throws IOException {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    public List<Throwable> getCauses() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append((String) null);
        sb2.append("");
        sb2.append("");
        sb2.append("");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb2.toString();
        }
        if (rootCauses.size() == 1) {
            sb2.append("\nThere was 1 cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(rootCauses.size());
            sb2.append(" causes:");
        }
        for (Throwable th2 : rootCauses) {
            sb2.append('\n');
            sb2.append(th2.getClass().getName());
            sb2.append('(');
            sb2.append(th2.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) throws IOException {
        d(this, printStream);
        b(getCauses(), new a(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) throws IOException {
        d(this, printWriter);
        b(getCauses(), new a(printWriter));
    }

    public static final class a implements Appendable {

        /* renamed from: b, reason: collision with root package name */
        public final Appendable f5572b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f5573m = true;

        public a(Appendable appendable) {
            this.f5572b = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            boolean z10 = this.f5573m;
            Appendable appendable = this.f5572b;
            if (z10) {
                this.f5573m = false;
                appendable.append("  ");
            }
            this.f5573m = c10 == '\n';
            appendable.append(c10);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z10 = this.f5573m;
            Appendable appendable = this.f5572b;
            boolean z11 = false;
            if (z10) {
                this.f5573m = false;
                appendable.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i11 - 1) == '\n') {
                z11 = true;
            }
            this.f5573m = z11;
            appendable.append(charSequence, i10, i11);
            return this;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
