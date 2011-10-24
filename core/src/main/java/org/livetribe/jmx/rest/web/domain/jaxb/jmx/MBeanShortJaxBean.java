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
package org.livetribe.jmx.rest.web.domain.jaxb.jmx;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;


/**
 *
 */
@XmlRootElement(name = "MBeans")
public class MBeanShortJaxBean implements Comparable<MBeanShortJaxBean>
{
    @XmlElement(name = "ObjectName")
    public String objectName;
    @XmlElement(name = "URL")
    public URI url;

    public MBeanShortJaxBean()
    {
    }

    public MBeanShortJaxBean(UriInfo uriInfo, String objectName)
    {
        this.objectName = objectName;
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(objectName);
        uriBuilder.replaceQueryParam("");
        this.url = uriBuilder.build();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("MBeanShortJaxBean [objectName=");
        builder.append(objectName);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }

    public int compareTo(MBeanShortJaxBean o)
    {
        return this.objectName.compareTo(o.objectName);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objectName == null) ? 0 : objectName.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MBeanShortJaxBean other = (MBeanShortJaxBean)obj;
        if (objectName == null)
        {
            if (other.objectName != null)
                return false;
        }
        else if (!objectName.equals(other.objectName))
            return false;
        if (url == null)
        {
            if (other.url != null)
                return false;
        }
        else if (!url.equals(other.url))
            return false;
        return true;
    }

}
