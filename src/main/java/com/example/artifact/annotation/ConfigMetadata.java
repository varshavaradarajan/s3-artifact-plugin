/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.artifact.annotation;

import com.example.artifact.utils.Util;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.example.artifact.utils.Util.isNotBlank;

public class ConfigMetadata<T extends Metadata> {

    @Expose
    @SerializedName("key")
    private String key;

    @Expose
    @SerializedName("metadata")
    private T metadata;

    public ConfigMetadata(String key, T metadata) {
        this.key = key;
        this.metadata = metadata;
    }

    public ValidationError validate(String input) {
        String validationError = doValidate(input);
        if (isNotBlank(validationError)) {
            return new ValidationError(key, validationError);
        }
        return null;
    }

    protected String doValidate(String input) {
        if (isRequired()) {
            if (Util.isBlank(input)) {
                return this.key + " must not be blank.";
            }
        }
        return null;
    }


    public String getKey() {
        return key;
    }

    public boolean isRequired() {
        return metadata.isRequired();
    }
}