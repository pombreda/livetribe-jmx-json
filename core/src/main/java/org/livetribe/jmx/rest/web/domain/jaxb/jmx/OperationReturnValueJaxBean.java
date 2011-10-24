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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 */
@XmlRootElement
public class OperationReturnValueJaxBean implements Comparable<OperationReturnValueJaxBean>
{

    @XmlElement(name = "NodeName")
    public String nodeName;
    public String returnValue;

    public OperationReturnValueJaxBean()
    {
    }

    public OperationReturnValueJaxBean(String nodeName, Object object)
    {
        this.nodeName = nodeName;
        this.returnValue = object == null ? "success" : object.toString();
    }

    public int compareTo(OperationReturnValueJaxBean o)
    {
        return nodeName.compareTo(o.nodeName);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("OperationReturnValueJaxBean [nodeName=");
        builder.append(nodeName);
        builder.append(", returnValue=");
        builder.append(returnValue);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodeName == null) ? 0 : nodeName.hashCode());
        result = prime * result + ((returnValue == null) ? 0 : returnValue.hashCode());
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
        OperationReturnValueJaxBean other = (OperationReturnValueJaxBean)obj;
        if (nodeName == null)
        {
            if (other.nodeName != null)
                return false;
        }
        else if (!nodeName.equals(other.nodeName))
            return false;
        if (returnValue == null)
        {
            if (other.returnValue != null)
                return false;
        }
        else if (!returnValue.equals(other.returnValue))
            return false;
        return true;
    }
}
