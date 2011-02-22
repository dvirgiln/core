/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.switchyard.transform.config.model.v1;

import javax.xml.namespace.QName;

import org.switchyard.config.Configuration;
import org.switchyard.config.model.Descriptor;
import org.switchyard.config.model.transform.TransformModel;
import org.switchyard.config.model.transform.v1.V1BaseTransformModel;
import org.switchyard.transform.config.model.SmooksConfigModel;
import org.switchyard.transform.config.model.SmooksTransformModel;

/**
 * V1SmooksTransformModel.
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; (C) 2011 Red Hat Inc.
 */
public class V1SmooksTransformModel extends V1BaseTransformModel implements SmooksTransformModel {

    private SmooksConfigModel _config;

    public V1SmooksTransformModel() {
        super(new QName(TransformModel.DEFAULT_NAMESPACE, TransformModel.TRANSFORM + '.' + SMOOKS));
        setModelChildrenOrder(SmooksConfigModel.CONFIG);
    }

    public V1SmooksTransformModel(Configuration config, Descriptor desc) {
        super(config, desc);
        setModelChildrenOrder(SmooksConfigModel.CONFIG);
    }

    @Override
    public SmooksConfigModel getConfig() {
        if (_config == null) {
            _config = (SmooksConfigModel)getFirstChildModelStartsWith(SmooksConfigModel.CONFIG);
        }
        return _config;
    }

    @Override
    public SmooksTransformModel setConfig(SmooksConfigModel config) {
        setChildModel(config);
        _config = config;
        return this;
    }

}