/*
 *
 *  Copyright 2017 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.hollow.core.write.objectmapper;


/**
 * Sample type that represents a direct circular reference between 2 classes.
 */
@SuppressWarnings("unused")
public class DirectCircularReference {

    private final String name;
    private final DirectCircularReference child;

    public DirectCircularReference(String name, DirectCircularReference child) {
        this.name = name;
        this.child = child;
    }
}