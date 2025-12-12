package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ThreadUtils {
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();

    public static final class AlwaysTruePredicate implements ThreadPredicate, ThreadGroupPredicate {
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return true;
        }

        private AlwaysTruePredicate() {
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return true;
        }
    }

    public static class NamePredicate implements ThreadPredicate, ThreadGroupPredicate {
        private final String name;

        public NamePredicate(String str) {
            Validate.isTrue(str != null, "The name must not be null", new Object[0]);
            this.name = str;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return threadGroup != null && threadGroup.getName().equals(this.name);
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getName().equals(this.name);
        }
    }

    public interface ThreadGroupPredicate {
        boolean test(ThreadGroup threadGroup);
    }

    public static class ThreadIdPredicate implements ThreadPredicate {
        private final long threadId;

        public ThreadIdPredicate(long j10) {
            if (j10 <= 0) {
                throw new IllegalArgumentException("The thread id must be greater than zero");
            }
            this.threadId = j10;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getId() == this.threadId;
        }
    }

    public interface ThreadPredicate {
        boolean test(Thread thread);
    }

    public static Thread findThreadById(long j10, ThreadGroup threadGroup) {
        Validate.isTrue(threadGroup != null, "The thread group must not be null", new Object[0]);
        Thread threadFindThreadById = findThreadById(j10);
        if (threadFindThreadById == null || !threadGroup.equals(threadFindThreadById.getThreadGroup())) {
            return null;
        }
        return threadFindThreadById;
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate threadGroupPredicate) {
        return findThreadGroups(getSystemThreadGroup(), true, threadGroupPredicate);
    }

    public static Collection<ThreadGroup> findThreadGroupsByName(String str) {
        return findThreadGroups(new NamePredicate(str));
    }

    public static Collection<Thread> findThreads(ThreadPredicate threadPredicate) {
        return findThreads(getSystemThreadGroup(), true, threadPredicate);
    }

    public static Collection<Thread> findThreadsByName(String str, ThreadGroup threadGroup) {
        return findThreads(threadGroup, false, new NamePredicate(str));
    }

    public static Collection<ThreadGroup> getAllThreadGroups() {
        return findThreadGroups(ALWAYS_TRUE_PREDICATE);
    }

    public static Collection<Thread> getAllThreads() {
        return findThreads(ALWAYS_TRUE_PREDICATE);
    }

    public static ThreadGroup getSystemThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z10, ThreadGroupPredicate threadGroupPredicate) {
        ThreadGroup[] threadGroupArr;
        int iEnumerate;
        Validate.isTrue(threadGroup != null, "The group must not be null", new Object[0]);
        Validate.isTrue(threadGroupPredicate != null, "The predicate must not be null", new Object[0]);
        int iActiveGroupCount = threadGroup.activeGroupCount();
        while (true) {
            int i10 = (iActiveGroupCount / 2) + iActiveGroupCount + 1;
            threadGroupArr = new ThreadGroup[i10];
            iEnumerate = threadGroup.enumerate(threadGroupArr, z10);
            if (iEnumerate < i10) {
                break;
            }
            iActiveGroupCount = iEnumerate;
        }
        ArrayList arrayList = new ArrayList(iEnumerate);
        for (int i11 = 0; i11 < iEnumerate; i11++) {
            if (threadGroupPredicate.test(threadGroupArr[i11])) {
                arrayList.add(threadGroupArr[i11]);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z10, ThreadPredicate threadPredicate) {
        Thread[] threadArr;
        int iEnumerate;
        Validate.isTrue(threadGroup != null, "The group must not be null", new Object[0]);
        Validate.isTrue(threadPredicate != null, "The predicate must not be null", new Object[0]);
        int iActiveCount = threadGroup.activeCount();
        while (true) {
            int i10 = (iActiveCount / 2) + iActiveCount + 1;
            threadArr = new Thread[i10];
            iEnumerate = threadGroup.enumerate(threadArr, z10);
            if (iEnumerate < i10) {
                break;
            }
            iActiveCount = iEnumerate;
        }
        ArrayList arrayList = new ArrayList(iEnumerate);
        for (int i11 = 0; i11 < iEnumerate; i11++) {
            if (threadPredicate.test(threadArr[i11])) {
                arrayList.add(threadArr[i11]);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<Thread> findThreadsByName(String str, String str2) {
        Validate.isTrue(str != null, "The thread name must not be null", new Object[0]);
        Validate.isTrue(str2 != null, "The thread group name must not be null", new Object[0]);
        Collection<ThreadGroup> collectionFindThreadGroups = findThreadGroups(new NamePredicate(str2));
        if (collectionFindThreadGroups.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        NamePredicate namePredicate = new NamePredicate(str);
        Iterator<ThreadGroup> it = collectionFindThreadGroups.iterator();
        while (it.hasNext()) {
            arrayList.addAll(findThreads(it.next(), false, namePredicate));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Thread findThreadById(long j10, String str) {
        Validate.isTrue(str != null, "The thread group name must not be null", new Object[0]);
        Thread threadFindThreadById = findThreadById(j10);
        if (threadFindThreadById == null || threadFindThreadById.getThreadGroup() == null || !threadFindThreadById.getThreadGroup().getName().equals(str)) {
            return null;
        }
        return threadFindThreadById;
    }

    public static Thread findThreadById(long j10) {
        Collection<Thread> collectionFindThreads = findThreads(new ThreadIdPredicate(j10));
        if (collectionFindThreads.isEmpty()) {
            return null;
        }
        return collectionFindThreads.iterator().next();
    }

    public static Collection<Thread> findThreadsByName(String str) {
        return findThreads(new NamePredicate(str));
    }
}
