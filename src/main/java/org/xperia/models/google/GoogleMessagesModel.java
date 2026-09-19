package org.xperia.models.google;

import java.util.List;

public record GoogleMessagesModel (String id, String threadId, List<String> labelIds) {}
