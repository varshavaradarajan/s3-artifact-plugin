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

package com.example.artifact.executors;

import com.example.artifact.annotation.ConfigMetadata;
import com.example.artifact.annotation.MetadataHelper;
import com.example.artifact.model.FetchArtifactConfig;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.List;

import static com.example.artifact.utils.Util.GSON;

public class GetFetchArtifactMetadataExecutor implements RequestExecutor {
    public GoPluginApiResponse execute() {
        final List<ConfigMetadata> metadata = MetadataHelper.getMetadata(FetchArtifactConfig.class);
        return DefaultGoPluginApiResponse.success( GSON.toJson(metadata));
    }
}

