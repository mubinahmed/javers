package org.javers.core.diff.appenders;

import org.javers.common.collections.Objects;
import org.javers.common.collections.Sets;
import org.javers.core.diff.NodePair;
import org.javers.core.diff.changetype.ReferenceChange;
import org.javers.model.domain.GlobalCdoId;
import org.javers.model.mapping.Property;
import org.javers.model.mapping.type.EntityReferenceType;
import org.javers.model.mapping.type.JaversType;
import org.javers.model.object.graph.Edge;
import org.javers.model.object.graph.SingleEdge;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author bartosz walacik
 * @author pawel szymczyk
 */
public class ReferenceChangeAppender extends PropertyChangeAppender<ReferenceChange> {

    @Override
    protected Class<? extends JaversType> getSupportedPropertyType() {
        return EntityReferenceType.class;
    }

    @Override
    public Collection<ReferenceChange> calculateChanges(NodePair pair, Property property) {
        Edge leftSingleEdge = pair.getLeft().getEdge(property);
        Edge rightSingleEdge = pair.getRight().getEdge(property);

        GlobalCdoId leftGlobalCdoId = getGlobalCdoId(leftSingleEdge);
        GlobalCdoId rightGlobalCdoId = getGlobalCdoId(rightSingleEdge);

        if (Objects.nullSafeEquals(leftGlobalCdoId, rightGlobalCdoId)) {
            return Collections.EMPTY_SET;
        }

        return Sets.asSet(new ReferenceChange(pair.getGlobalCdoId(),
                property,
                leftGlobalCdoId,
                rightGlobalCdoId));
    }

    private GlobalCdoId getGlobalCdoId(Edge edge) {
        return edge != null ? ((SingleEdge) edge).getReference().getGlobalCdoId() : null;
    }
}
