package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import v9.l;
import v9.u;

/* loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements x {

    /* renamed from: b, reason: collision with root package name */
    public final l f10110b;

    public static final class a<E> extends w<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        public final g f10111a;

        /* renamed from: b, reason: collision with root package name */
        public final u<? extends Collection<E>> f10112b;

        public a(i iVar, Type type, w<E> wVar, u<? extends Collection<E>> uVar) {
            this.f10111a = new g(iVar, wVar, type);
            this.f10112b = uVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.w
        public Collection<E> read(z9.a aVar) throws IOException {
            if (aVar.peek() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> collectionConstruct = this.f10112b.construct();
            aVar.beginArray();
            while (aVar.hasNext()) {
                collectionConstruct.add(this.f10111a.read(aVar));
            }
            aVar.endArray();
            return collectionConstruct;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.nullValue();
                return;
            }
            bVar.beginArray();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f10111a.write(bVar, it.next());
            }
            bVar.endArray();
        }
    }

    public CollectionTypeAdapterFactory(l lVar) {
        this.f10110b = lVar;
    }

    @Override // com.google.gson.x
    public <T> w<T> create(i iVar, y9.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
        return new a(iVar, collectionElementType, iVar.getAdapter(y9.a.get(collectionElementType)), this.f10110b.get(aVar));
    }
}
