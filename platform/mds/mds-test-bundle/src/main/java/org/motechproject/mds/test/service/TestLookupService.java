package org.motechproject.mds.test.service;

import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;
import org.motechproject.mds.test.domain.TestLookup;

import java.util.List;

public interface TestLookupService extends MotechDataService<TestLookup> {

    @Lookup(name = "By Inherited Field")
    List<TestLookup> findByInheritedField(@LookupField(name = "superClassString") String superClassString);

    @Lookup(name = "By AutoGenerated Field")
    List<TestLookup> findByAutoGeneratedField(@LookupField(name = "creator") String creator);
}
