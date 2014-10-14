/*
 * Copyright 2014 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.guvnor.m2repo.client.widgets;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwtmockito.GwtMock;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.guvnor.m2repo.model.JarListPageRow;
import org.guvnor.m2repo.service.M2RepoService;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.uberfire.paging.PageRequest;

@RunWith(GwtMockitoTestRunner.class)
public class ArtifactListPresenterImplTest {

    private static final String MOCK_FILTER = "mock filter";
    @GwtMock
    private ArtifactListViewImpl view;
    @Mock
    private HasData<JarListPageRow> dataGrid;
    @Mock
    private Caller<M2RepoService> m2RepoServiceCaller;
    @Mock
    private M2RepoService m2RepoService;
    // FIXME fails with
    // java.lang.ClassCastException: $javax.enterprise.event.Event$$EnhancerByMockitoWithCGLIB$$622ebeb5 cannot be cast to org.mockito.cglib.proxy.Factory
//    @Mock
//    private Event<NotificationEvent> notification;
//    @Captor
//    private ArgumentCaptor<NotificationEvent> c;

    // http://tedvinke.wordpress.com/2014/02/13/mockito-why-you-should-not-use-injectmocks-annotation-to-autowire-fields/
    @InjectMocks
    private ArtifactListPresenterImpl artifactList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // wire M2RepoService mock with it's caller
        Mockito.when(m2RepoServiceCaller.call(Mockito.any(RemoteCallback.class))).thenReturn(m2RepoService);
        // stub visible range of the grid
        Mockito.when(dataGrid.getVisibleRange()).thenReturn(new Range(1, 2));
        // stub display and current filter
        Mockito.when(view.getDisplay()).thenReturn(dataGrid);
        Mockito.when(view.getCurrentFilter()).thenReturn(MOCK_FILTER);

        artifactList.init();
    }

    @Test
    public void testSearch() {
        String testFilter = "set filter";
        artifactList.search(testFilter);
        Mockito.verify(view).setCurrentFilter(testFilter);
        Mockito.verify(m2RepoService).listJars(Mockito.any(PageRequest.class), Mockito.eq(MOCK_FILTER));
//        Mockito.verify(notification).fire(c.capture());
//        Assert.assertThat(c.getValue().getNotification(), CoreMatchers.equalTo(M2RepoEditorConstants.INSTANCE.RefreshedSuccessfully()));
    }

    @Test
    public void testShowPom() {
        // TODO how to click Open button in a dependency row?
        artifactList.getView().fireEvent(null);
    }
}
