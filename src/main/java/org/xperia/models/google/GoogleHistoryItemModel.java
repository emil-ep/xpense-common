package org.xperia.models.google;

import java.util.List;

public record GoogleHistoryItemModel (String id,
                                      List<GoogleMessagesModel> messages,
                                      List<GoogleHistoryMessagesAddedModel> messagesAdded,
                                      List<GoogleHistoryMessagesAddedModel> labelsRemoved) {}
