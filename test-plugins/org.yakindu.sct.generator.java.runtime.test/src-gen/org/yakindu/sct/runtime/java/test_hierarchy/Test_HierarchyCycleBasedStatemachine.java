/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_hierarchy;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_HierarchyCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State9, State10, State2, State3, State4, State5, State6, State7, State8, $NullState$
	};

	private DefaultInterfaceImpl defaultInterface;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_HierarchyCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(16);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceImpl(this);

	}

	protected Collection<Event<? extends Enum<?>>> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event<? extends Enum<?>>> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		occuredEvents.clear();
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	private DefaultInterfaceImpl getDefaultInterfaceImpl() {
		return defaultInterface;
	}

	public void enter() {
		getDefaultInterfaceImpl().setVarS1(0);
		getDefaultInterfaceImpl().setVarS1(1);

		getDefaultInterfaceImpl().setVarS1(
				getDefaultInterfaceImpl().getVarS1() + (1));

		nextStateIndex = 0;
		stateVector[0] = State.State9;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case State9 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				break;

			case State10 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				break;

			case State3 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			case State5 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			case State7 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			case State8 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			default :
				break;
		}

	}

	private void reactState1() {
	}
	private void reactState9() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State9 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				case State10 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() - (1));

			getDefaultInterfaceImpl().setVarS2(1);

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent9())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State10;

			}

		}
	}
	private void reactState10() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State9 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				case State10 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() - (1));

			getDefaultInterfaceImpl().setVarS2(1);

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent10())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State9;

			}

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent2())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent11())) {
					//Handle exit of all possible states (of Region2) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State7 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS1(1);

					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State9;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent14())) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case State3 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State5 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State7 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State8 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							default :
								break;
						}

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS1(1);

						getDefaultInterfaceImpl().setVarS1(
								getDefaultInterfaceImpl().getVarS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					}
				}
			}

		}
	}
	private void reactState4() {
	}
	private void reactState5() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent7())) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent3())) {
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State7;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent12())) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case State3 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State5 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State7 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State8 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							default :
								break;
						}

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS1(1);

						getDefaultInterfaceImpl().setVarS1(
								getDefaultInterfaceImpl().getVarS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					} else {
						if (occuredEvents.contains(getDefaultInterfaceImpl()
								.getEventEvent15())) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case State3 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State5 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State7 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State8 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								default :
									break;
							}

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS1(1);

							getDefaultInterfaceImpl().setVarS1(
									getDefaultInterfaceImpl().getVarS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.State10;

						}
					}
				}

			}

		}
	}
	private void reactState6() {
	}
	private void reactState7() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent7())) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent8())) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case State7 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent4())) {
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}
	}
	private void reactState8() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent7())) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent8())) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case State7 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent5())) {
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State7;

					} else {
						if (occuredEvents.contains(getDefaultInterfaceImpl()
								.getEventEvent13())) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case State3 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State5 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State7 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State8 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								default :
									break;
							}

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS1(1);

							getDefaultInterfaceImpl().setVarS1(
									getDefaultInterfaceImpl().getVarS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.State9;

						} else {
							if (occuredEvents
									.contains(getDefaultInterfaceImpl()
											.getEventEvent16())) {
								//Handle exit of all possible states (of Region2) at position 0...
								switch (stateVector[0]) {

									case State3 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									case State5 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									case State7 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									case State8 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									default :
										break;
								}

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl().setVarS1(1);

								getDefaultInterfaceImpl()
										.setVarS1(
												getDefaultInterfaceImpl()
														.getVarS1() + (1));

								nextStateIndex = 0;
								stateVector[0] = State.State10;

							}
						}
					}

				}

			}

		}
	}
	public void runCycle() {
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case State1 :
					reactState1();
					break;
				case State9 :
					reactState9();
					break;
				case State10 :
					reactState10();
					break;
				case State2 :
					reactState2();
					break;
				case State3 :
					reactState3();
					break;
				case State4 :
					reactState4();
					break;
				case State5 :
					reactState5();
					break;
				case State6 :
					reactState6();
					break;
				case State7 :
					reactState7();
					break;
				case State8 :
					reactState8();
					break;
				default :
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
