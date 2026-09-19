package org.xperia.models.google;

import java.util.List;

public record GoogleHistoryResponse (String historyId, List<GoogleHistoryItemModel> history) {}
