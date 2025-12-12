package com.comcast.viper.hlsparserj;

import com.comcast.viper.hlsparserj.tags.Tag;
import com.comcast.viper.hlsparserj.tags.TagFactory;
import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import com.comcast.viper.hlsparserj.tags.Version;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public abstract class AbstractPlaylist implements IPlaylist {
    protected List<UnparsedTag> tags;
    protected PlaylistVersion version;
    protected ConcurrentHashMap<String, List<Tag>> parsedTagListCache = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Tag> parsedTagCache = new ConcurrentHashMap<>();

    public AbstractPlaylist(PlaylistVersion playlistVersion, List<UnparsedTag> list) {
        this.version = playlistVersion;
        this.tags = list;
    }

    public Tag getTag(String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Tag tagCreateTag = this.parsedTagCache.get(str);
        if (tagCreateTag == null) {
            for (UnparsedTag unparsedTag : this.tags) {
                if (unparsedTag.getTagName().equals(str)) {
                    tagCreateTag = TagFactory.createTag(str);
                    tagCreateTag.setTag(unparsedTag);
                }
            }
            if (tagCreateTag != null) {
                this.parsedTagCache.put(str, tagCreateTag);
            }
        }
        return tagCreateTag;
    }

    public List<? extends Tag> getTagList(String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        List<Tag> list = this.parsedTagListCache.get(str);
        List<Tag> list2 = list;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            for (UnparsedTag unparsedTag : this.tags) {
                if (unparsedTag.getTagName().equals(str)) {
                    Tag tagCreateTag = TagFactory.createTag(str);
                    tagCreateTag.setTag(unparsedTag);
                    arrayList.add(tagCreateTag);
                }
            }
            this.parsedTagListCache.put(str, arrayList);
            list2 = arrayList;
        }
        return list2;
    }

    @Override // com.comcast.viper.hlsparserj.IPlaylist
    public List<UnparsedTag> getTags() {
        return this.tags;
    }

    @Override // com.comcast.viper.hlsparserj.IPlaylist
    public Version getVersion() {
        return (Version) getTag("EXT-X-VERSION");
    }

    @Override // com.comcast.viper.hlsparserj.IPlaylist
    public abstract boolean isMasterPlaylist();

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (UnparsedTag unparsedTag : this.tags) {
            sb2.append(unparsedTag.getRawTag());
            if (unparsedTag.getURI() != null) {
                sb2.append(StringUtils.LF);
                sb2.append(unparsedTag.getURI());
            }
            sb2.append(StringUtils.LF);
        }
        return sb2.toString();
    }
}
