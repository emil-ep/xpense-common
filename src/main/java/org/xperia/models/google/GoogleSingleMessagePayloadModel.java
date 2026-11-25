package org.xperia.models.google;

import java.util.List;

public record GoogleSingleMessagePayloadModel(String partId, List<GoogleSingleMessageHeaderModel> headers) {
}
