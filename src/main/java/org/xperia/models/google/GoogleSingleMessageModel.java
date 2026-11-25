package org.xperia.models.google;

import java.util.List;

public record GoogleSingleMessageModel(String id, String threadId, List<String> labelIds, String snippet, GoogleSingleMessagePayloadModel payload) {
}
