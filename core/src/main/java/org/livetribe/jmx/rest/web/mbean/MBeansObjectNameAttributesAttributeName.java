/**
 *
 * Copyright 2011 (C) The original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.livetribe.jmx.rest.web.mbean;

import javax.management.InstanceNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.livetribe.jmx.rest.web.BaseAggregateWebController;
import org.livetribe.jmx.rest.web.domain.JMXNode;
import org.livetribe.jmx.rest.web.domain.jaxb.jmx.MBeanAttributeValueJaxBeans;
import org.livetribe.jmx.rest.web.util.FilterNodesUtils;


/**
 *
 */
@Path("/mbeans/{objectName}/attributes/{attributeName}")
public class MBeansObjectNameAttributesAttributeName extends BaseAggregateWebController
{
    @Context
    UriInfo uriInfo;

    @GET
    @Produces(
    { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public MBeanAttributeValueJaxBeans getAttribute(@PathParam("objectName") String objectName, @PathParam("attributeName") String attributeName, @QueryParam("nodes") String nodes)
    {
        Collection<JMXNode> jmxNodes = FilterNodesUtils.getNodesToAggregate(nodes);
        try
        {
            return aggregateService.getAttributeValues(jmxNodes,objectName,attributeName);
        }
        catch (InstanceNotFoundException e)
        {
            Log.info("getAttribute: ", e);
            return null;
        }
    }

}
