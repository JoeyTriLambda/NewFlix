package l0;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* compiled from: Person.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f15704a;

    /* renamed from: b, reason: collision with root package name */
    public final IconCompat f15705b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15706c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15707d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f15708e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f15709f;

    /* compiled from: Person.java */
    public static class a {
        public static w a(Person person) {
            return new b().setName(person.getName()).setIcon(person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }

        public static Person b(w wVar) {
            return new Person.Builder().setName(wVar.getName()).setIcon(wVar.getIcon() != null ? wVar.getIcon().toIcon() : null).setUri(wVar.getUri()).setKey(wVar.getKey()).setBot(wVar.isBot()).setImportant(wVar.isImportant()).build();
        }
    }

    /* compiled from: Person.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f15710a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f15711b;

        /* renamed from: c, reason: collision with root package name */
        public String f15712c;

        /* renamed from: d, reason: collision with root package name */
        public String f15713d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f15714e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f15715f;

        public w build() {
            return new w(this);
        }

        public b setBot(boolean z10) {
            this.f15714e = z10;
            return this;
        }

        public b setIcon(IconCompat iconCompat) {
            this.f15711b = iconCompat;
            return this;
        }

        public b setImportant(boolean z10) {
            this.f15715f = z10;
            return this;
        }

        public b setKey(String str) {
            this.f15713d = str;
            return this;
        }

        public b setName(CharSequence charSequence) {
            this.f15710a = charSequence;
            return this;
        }

        public b setUri(String str) {
            this.f15712c = str;
            return this;
        }
    }

    public w(b bVar) {
        this.f15704a = bVar.f15710a;
        this.f15705b = bVar.f15711b;
        this.f15706c = bVar.f15712c;
        this.f15707d = bVar.f15713d;
        this.f15708e = bVar.f15714e;
        this.f15709f = bVar.f15715f;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        String key = getKey();
        String key2 = wVar.getKey();
        return (key == null && key2 == null) ? Objects.equals(Objects.toString(getName()), Objects.toString(wVar.getName())) && Objects.equals(getUri(), wVar.getUri()) && Objects.equals(Boolean.valueOf(isBot()), Boolean.valueOf(wVar.isBot())) && Objects.equals(Boolean.valueOf(isImportant()), Boolean.valueOf(wVar.isImportant())) : Objects.equals(key, key2);
    }

    public IconCompat getIcon() {
        return this.f15705b;
    }

    public String getKey() {
        return this.f15707d;
    }

    public CharSequence getName() {
        return this.f15704a;
    }

    public String getUri() {
        return this.f15706c;
    }

    public int hashCode() {
        String key = getKey();
        return key != null ? key.hashCode() : Objects.hash(getName(), getUri(), Boolean.valueOf(isBot()), Boolean.valueOf(isImportant()));
    }

    public boolean isBot() {
        return this.f15708e;
    }

    public boolean isImportant() {
        return this.f15709f;
    }

    public String resolveToLegacyUri() {
        String str = this.f15706c;
        if (str != null) {
            return str;
        }
        CharSequence charSequence = this.f15704a;
        if (charSequence == null) {
            return "";
        }
        return "name:" + ((Object) charSequence);
    }

    public Person toAndroidPerson() {
        return a.b(this);
    }
}
