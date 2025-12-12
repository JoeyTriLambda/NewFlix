package com.comcast.viper.hlsparserj;

import com.comcast.viper.hlsparserj.tags.TagNames;
import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class PlaylistParser {
    private static final String TAGPATTERN = "^#EXT.*";
    private static final String URIPATTERN = "^[^#].*";
    private InputStream playlistStream;
    private boolean isMasterPlaylist = false;
    private final List<UnparsedTag> tags = new ArrayList();

    private void parseInputStream() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.playlistStream));
        UnparsedTag unparsedTagProcessLine = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            } else {
                unparsedTagProcessLine = processLine(line, unparsedTagProcessLine);
            }
        }
    }

    private void parseString(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, StringUtils.LF);
        UnparsedTag unparsedTagProcessLine = null;
        while (stringTokenizer.hasMoreElements()) {
            unparsedTagProcessLine = processLine(stringTokenizer.nextToken(), unparsedTagProcessLine);
        }
    }

    private UnparsedTag processLine(String str, UnparsedTag unparsedTag) {
        if (!str.matches(TAGPATTERN)) {
            if (str.matches(URIPATTERN) && unparsedTag != null) {
                unparsedTag.setURI(str);
            }
            return unparsedTag;
        }
        UnparsedTag unparsedTag2 = new UnparsedTag(str);
        this.tags.add(unparsedTag2);
        if (unparsedTag2.getTagName().equals(TagNames.EXTXSTREAMINF)) {
            this.isMasterPlaylist = true;
        }
        return unparsedTag2;
    }

    public List<UnparsedTag> getTags() {
        return this.tags;
    }

    public boolean isMasterPlaylist() {
        return this.isMasterPlaylist;
    }

    public void parse(String str) {
        parseString(str);
    }

    public void parse(InputStream inputStream) throws IOException {
        this.playlistStream = inputStream;
        parseInputStream();
    }
}
